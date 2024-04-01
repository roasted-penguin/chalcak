package com.penguin.chalcak.service.impl;

import com.penguin.chalcak.exception.ApplicationErrorType;
import com.penguin.chalcak.exception.ApplicationException;
import com.penguin.chalcak.model.dto.ImageRecognitionExternalRequest;
import com.penguin.chalcak.model.dto.ImageRecognitionExternalResponse;
import com.penguin.chalcak.model.dto.ImageRecognitionInternalResponse;
import com.penguin.chalcak.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final String INVOKE_URL = "https://1dcl38fgey.apigw.ntruss.com/custom/v1/27690/4360176bb005456207aa42b5b328426fa58b52e1fbfa65da1b28badb875a006f/general";
    private final String IMAGE_ACCOUNT = "계좌번호.jpeg";

    public ImageRecognitionInternalResponse extractText(String imageUrl){
        //header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type","application/json");
        /**jasypt**/
        String clientSecretKey = "";//
        headers.set("X-OCR-SECRET",clientSecretKey);

        String base64Image = "";
        try{
            File imageFile = ResourceUtils.getFile("classpath:static/" + IMAGE_ACCOUNT);
            FileInputStream fis = new FileInputStream(imageFile);
            byte[] bytesArray = new byte[(int) imageFile.length()];
            fis.read(bytesArray);
            fis.close();

            // Base64로 인코딩
            base64Image = Base64.getEncoder().encodeToString(bytesArray);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //body
        /**
         * 프론트에서 이미지를 s3에 올리고 그 이미지 url을 extractText인자로 받아와야한다.
         그래야 url 확정 가능(원격 url 필요)
         우선은 하드코딩으로 url 박기
         **/
        imageUrl = "https://lettercounter.net/wp-content/uploads/2021/03/lettercounter.png";

        String[] imageUrlSplit = imageUrl.split("\\.");
        String format = imageUrlSplit[imageUrlSplit.length-1];

        ImageRecognitionExternalRequest imageRecognitionExternalRequest = ImageRecognitionExternalRequest.builder()
                .version("V2")
                .requestId("chalcak")
                .timestamp(0)
                .lang("ko")
                .images(List.of(
                        ImageRecognitionExternalRequest.Image.builder()
                                .format(format)
                                // .url(imageUrl)
                                .data(base64Image) // url 있으면 data 필요 x
                                .name("testImage 1")
                                .build()
                ))
                .enableTableDetection(false)
                .build();

        // 외부 API request
        /**jasypt**/
        ImageRecognitionExternalResponse imageRecognitionExternalResponse;
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<ImageRecognitionExternalRequest> request = new HttpEntity<>(imageRecognitionExternalRequest,headers);
            imageRecognitionExternalResponse = restTemplate.postForObject(INVOKE_URL, request, ImageRecognitionExternalResponse.class);
        } catch (Exception e){
            e.printStackTrace();
            throw new ApplicationException(ApplicationErrorType.NAVER_EXTERNAL_API_EXCEPTION);
        }

        ImageRecognitionInternalResponse imageRecognitionInternalResponse = processImageData(imageRecognitionExternalResponse);
        return imageRecognitionInternalResponse;
    }

    private ImageRecognitionInternalResponse processImageData(ImageRecognitionExternalResponse imageRecognitionExternalResponse){
       ImageRecognitionExternalResponse.Image image = imageRecognitionExternalResponse.getImages().get(0);
       String inferredText = "";
       double inferredConfidence = 1.0;
       for(ImageRecognitionExternalResponse.Image.Field field : image.getFields()){
           inferredText += field.getInferText();
           inferredConfidence *= field.getInferConfidence();
       }
       return ImageRecognitionInternalResponse.builder()
               .inferredText(inferredText)
               .inferredConfidence(inferredConfidence)
               .build();
    }
}
