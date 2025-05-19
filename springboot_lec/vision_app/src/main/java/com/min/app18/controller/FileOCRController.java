package com.min.app18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.min.app18.service.VisionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FileOCRController {

  private final VisionService visionService;
  
  @PostMapping(value = "/image/recognize")
  public String image_recognize(@RequestParam("image") MultipartFile multipartFile) {
    if(multipartFile.isEmpty()) {
      return "index";
    }
    System.out.println("업로드 이미지 파일명: " + multipartFile.getOriginalFilename());
    try {
      String imageText = visionService.extractTextFromImage(multipartFile);
      System.out.println(imageText);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "index";
  }
  
  @PostMapping(value = "/pdf/recognize") 
  public String pdf_recognize(@RequestParam("pdf") MultipartFile multipartFile) {
    if(multipartFile.isEmpty()) {
      return "index";
    }
    System.out.println("업로드 PDF 파일명: " + multipartFile.getOriginalFilename());
    try {
      String pdfText = visionService.extractTextFromPDF(multipartFile);
      System.out.println(pdfText);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "index";
  }
  
}
