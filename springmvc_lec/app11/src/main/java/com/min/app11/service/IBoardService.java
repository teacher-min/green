package com.min.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.min.app11.dto.BoardDto;

public interface IBoardService {
  Map<String, Object> getBoardList(HttpServletRequest request);
  BoardDto getBoardById(int boardId);
  String modifyBoard(BoardDto boardDto);
  String removeBoard(int boardId);
  String removeBoardList(String[] numbers);
  String registerBoard(BoardDto boardDto);
  Map<String, Object> getSearchList(HttpServletRequest request);
  void txTest();
}
