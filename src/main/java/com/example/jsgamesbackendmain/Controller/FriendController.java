package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendRequestListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendSort;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
import com.example.jsgamesbackendmain.Service.FriendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FriendController {

    private final FriendService friendService;

    //친구 추가 요청
    @Operation(summary = "친구 추가 요청")
    @PostMapping("/friend/request")
    public StateResponseDTO requestFriend(@RequestBody FriendRequestDTO friendRequestDTO) {
        return friendService.requestFriend(friendRequestDTO);
    }

    //친구 추가 요청받은 목록
    @Operation(summary = "친구 추가 요청보낸 목록")
    @GetMapping("/friend/requests/{userId}")
    public List<FriendRequestListResponseDTO> requestList(@PathVariable String userId,
                                                          @Parameter @Min(0) Integer page,
                                                          @Parameter @Min(0) @Max(10) Integer size) {
        return friendService.requestList(userId, page, size);
    }

    //친구 추가 보낸 요청 삭제
    @Operation(summary = "친구 추가 보낸 요청 삭제")
    @DeleteMapping("/friend/request")
    public StateResponseDTO deleteRequest(@RequestBody FriendRequestDTO friendRequestDTO) {
        return friendService.deleteRequest(friendRequestDTO);
    }

    //친구 추가 요청보낸 목록
    @Operation(summary = "친구 추가 요청받은 목록")
    @GetMapping("/friend/requested/{userId}")
    public List<FriendRequestListResponseDTO> requestedList(@PathVariable String userId,
                                      @Parameter @Min(0) Integer page,
                                      @Parameter @Min(0) @Max(10) Integer size) {
        return friendService.requestedList(userId, page, size);
    }

    //친구 추가 수락
    @Operation(summary = "친구 추가 수락")
    @PostMapping("/friend/accept")
    public StateResponseDTO acceptFriend(@RequestBody FriendRequestDTO friendRequestDTO) {
        return friendService.acceptFriend(friendRequestDTO);
    }

    //친구 추가 거절
    @Operation(summary = "친구 추가 거절")
    @PostMapping("/friend/reject")
    public StateResponseDTO rejectFriend(@RequestBody FriendRequestDTO friendRequestDTO) {
        return friendService.rejectFriend(friendRequestDTO);
    }

    //친구 목록
    @Operation(summary = "친구 목록")
    @GetMapping("/friends/{userId}")
    public List<FriendListResponseDTO> friendList(@PathVariable String userId,
                                                  @Parameter @Min(0) Integer page,
                                                  @Parameter @Min(0) @Max(10) Integer size,
                                                  @RequestParam(defaultValue = "TIME") FriendSort sort) {
        return friendService.friendList(userId, page, size, sort);
    }

    //친구 삭제
    @Operation(summary = "친구 삭제")
    @DeleteMapping("/friend")
    public StateResponseDTO deleteFriend(@RequestBody FriendRequestDTO friendRequestDTO) {
        return friendService.deleteFriend(friendRequestDTO);
    }
}
