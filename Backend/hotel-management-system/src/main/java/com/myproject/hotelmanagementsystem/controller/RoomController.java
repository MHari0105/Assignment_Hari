package com.myproject.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.hotelmanagementsystem.entity.Room;
import com.myproject.hotelmanagementsystem.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody Room room) {
        return new ResponseEntity<>(roomService.createRoom(room), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAllNonOccupiedRooms() {
        return new ResponseEntity<>(roomService.getFreeRooms(), HttpStatus.OK);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> changeRoomStatus(@PathVariable Long roomId, @RequestBody Room room) {
        return new ResponseEntity<>(roomService.changeStatus(roomId, room), HttpStatus.OK);
    }
}
