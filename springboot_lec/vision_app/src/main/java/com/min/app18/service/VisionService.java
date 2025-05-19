package com.min.app18.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.AnnotateFileRequest;
import com.google.cloud.vision.v1.AnnotateFileResponse;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.InputConfig;
import com.google.protobuf.ByteString;

@Service
public class VisionService {

  /*
   * 임의의 이미지에서 텍스트를 감지하고 추출하는 메소드
   * 1. TEXT_DETECTION          : 일반 이미지
   * 2. DOCUMENT_TEXT_DETECTION : 밀집된 텍스트를 가진 이미지
   */
  public String extractTextFromImage(MultipartFile multipartFile) throws Exception {
    
    // 이미지에서 추출한 텍스트를 저장할 StringBuilder
    StringBuilder builder = new StringBuilder();

    // 이미지를 ByteString으로 변환
    ByteString imageBytes = ByteString.copyFrom(multipartFile.getBytes());
    
    // 요청 클라이언트 초기화 (한 번만 생성하면 여러 요청에서 재사용 가능. client.close() 자동 호출
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      
      // 요청 정보를 저장할 List
      List<AnnotateImageRequest> requests = new ArrayList<>();

      // Vision API로 전달할 Image
      Image image = Image.newBuilder()
          .setContent(imageBytes)
          .build();
      
      // Vision API가 감지할 Feature Type
      Feature feature = Feature.newBuilder()
          .setType(Feature.Type.TEXT_DETECTION)  // 텍스트 감지
          .build();
    
      // OCR 요청 생성
      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
          .setImage(image)
          .addFeatures(feature)
          .build();
      requests.add(request);
    
      // OCR 요청 실행
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      
      // OCR 응답 리스트 받아오기
      List<AnnotateImageResponse> results = response.getResponsesList();
      
      // OCR 응답 객체 리스트 순회
      for(AnnotateImageResponse result : results) {
        
        // 에러 처리
        if(result.hasError()) {
          return "Error: " + result.getError().getMessage();
        }
        
        // 응답 객체 확인 (각 단어 및 전체 텍스트 확인 가능)
        System.out.println(result.toString());
        
        // 응답 객체가 가진 전체 텍스트 저장
        builder.append(result.getFullTextAnnotation().getText());
        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return builder.toString();
    
  }
  
  /*
   * PDF 문서의 텍스트를 감지하는 메소드
   * 최대 2,000페이지의 PDF 파일 허용
   */
  public String extractTextFromPDF(MultipartFile multipartFile) throws Exception {
    
    // 이미지에서 추출한 텍스트를 저장할 StringBuilder
    StringBuilder builder = new StringBuilder();
    
    // PDF 문서를 ByteString으로 변환
    ByteString pdfBytes = ByteString.copyFrom(multipartFile.getBytes());
    
    // 요청 클라이언트 초기화 (한 번만 생성하면 여러 요청에서 재사용 가능. client.close() 자동 호출
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      
      // 요청 정보를 저장할 List
      List<AnnotateFileRequest> requests = new ArrayList<>();
      
      // PDF MIME 타입 설정
      InputConfig inputConfig = InputConfig.newBuilder()
          .setContent(pdfBytes)
          .setMimeType("application/pdf")  // Supported MimeTypes: "application/pdf", "image/tiff"
          .build();
      
      // Vision API가 감지할 Feature Type
      Feature feature = Feature.newBuilder()
          .setType(Feature.Type.DOCUMENT_TEXT_DETECTION)  // DOCUMENT_TEXT_DETECTION or TEXT_DETECTION 모두 가능
          .build();
      
      // OCR 요청 생성
      AnnotateFileRequest request = AnnotateFileRequest.newBuilder()
          .setInputConfig(inputConfig)
          .addFeatures(feature)
          .build();
      requests.add(request);
      
      // OCR 요청 실행
      BatchAnnotateFilesResponse response = client.batchAnnotateFiles(requests);
      
      // OCR 응답 객체 리스트 받아오기
      List<AnnotateFileResponse> results = response.getResponsesList();

      // OCR 응답 객체 리스트 순회
      for(AnnotateFileResponse result : results) {
        
        // 에러 처리
        if(result.hasError()) {
          return "Error: " + result.getError().getMessage();
        }
        
        // 응답 객체 확인 (각 단어 및 전체 텍스트 확인 가능)
        System.out.println(result.toString());
        
        // 응답 객체 파싱
        AnnotateImageResponse annotateImageResponse = result.getResponses(0);
        
        // 응답 객체가 가진 전체 텍스트 저장
        builder.append(annotateImageResponse.getFullTextAnnotation().getText());
        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return builder.toString();
    
  }
  
}
