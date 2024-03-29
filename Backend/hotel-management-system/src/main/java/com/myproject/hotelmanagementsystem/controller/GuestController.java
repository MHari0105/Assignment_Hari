package com.myproject.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.hotelmanagementsystem.entity.Guest;
import com.myproject.hotelmanagementsystem.exception.InvalidSearchException;
import com.myproject.hotelmanagementsystem.service.GuestService;

@RestController
@RequestMapping("api/guest")
public class GuestController {
    
    @Autowired
    private GuestService guestService;

    @PostMapping("/post")
    public ResponseEntity<String> createGuest(@RequestBody Guest guest) {
        return new ResponseEntity<>(guestService.addGuest(guest), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Guest>> getAllGuests() {
        return new ResponseEntity<>(guestService.getAllGuests(), HttpStatus.OK);
    }

    @GetMapping("/get/{guestId}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long guestId) {
        return new ResponseEntity<>(guestService.getGuestById(guestId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{guestId}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long guestId) {
        return new ResponseEntity<>(guestService.deleteGuest(guestId), HttpStatus.OK);
    }

    @PutMapping("/put/{guestId}")
    public ResponseEntity<Guest> updateGuests(@PathVariable Long guestId, @RequestBody Guest guest) throws InvalidSearchException {
        return new ResponseEntity<>(guestService.updateGuest(guestId, guest), HttpStatus.OK);
    }
}
