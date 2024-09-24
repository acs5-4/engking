package com.Ikuzo.EngKing.controller;

import com.Ikuzo.EngKing.dto.ChatRoomRequestDto;
import com.Ikuzo.EngKing.dto.ChatRoomResponseDto;
import com.Ikuzo.EngKing.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/chatroom")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/chatroomlist")
    public ResponseEntity<List<ChatRoomResponseDto>> selectChatRoomsByMemberId(@RequestBody ChatRoomRequestDto chatRoomRequestDto) {
        String memberId = chatRoomRequestDto.getMemberId();

        List<ChatRoomResponseDto> chatRoomResponseDtoLists = chatRoomService.selectChatRoomsByMemberId(memberId);

        return ResponseEntity.status(HttpStatus.OK).body(chatRoomResponseDtoLists);
    }

    @PostMapping("/deletechatroom")
    public ResponseEntity<ChatRoomResponseDto> deleteChatRoomByChatRoomId(@RequestBody ChatRoomRequestDto chatRoomRequestDto) {
        String memberId = chatRoomRequestDto.getMemberId();
        String chatRoomId = chatRoomRequestDto.getChatRoomId();

        ChatRoomResponseDto chatRoomResponseDto = chatRoomService.deleteChatRoomByChatRoomIdAndMemberId(memberId, chatRoomId);

        return ResponseEntity.status(HttpStatus.OK).body(chatRoomResponseDto);
    }

}
