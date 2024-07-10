package com.dhotels.hotelsbackend.controllers;

import com.dhotels.hotelsbackend.helpers.NewRoomRequest;
import com.dhotels.hotelsbackend.helpers.NewRoomTypeRequest;
import com.dhotels.hotelsbackend.helpers.UpdateRoomReq;
import com.dhotels.hotelsbackend.helpers.UpdateRoomTypeRequest;
import com.dhotels.hotelsbackend.modules.Room;
import com.dhotels.hotelsbackend.modules.RoomType;
import com.dhotels.hotelsbackend.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/api/v1/bookings")
public class RoomsController {


    @Autowired
    RoomService roomService;


    @PostMapping("/addRoom")
    public ResponseEntity<Room> addRoom(
            @RequestBody NewRoomRequest newRoomRequest
            ){

        Room room = roomService.addRoom(newRoomRequest);

        return new ResponseEntity<Room>(room, HttpStatus.CREATED);
    }


    @PostMapping("/addRoom/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable("id") Integer roomId,
            @RequestBody UpdateRoomReq updateRoomReq
    ){

        Room room = roomService.updateRoom(roomId, updateRoomReq);

        return new ResponseEntity<Room>(room, HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteRoom/{id}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable("id") Integer roomId
    ){
        roomService.deleteRoom(roomId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @GetMapping("/getRoomByID/{id}")
    public ResponseEntity<Room>  getRoomsById(
            @PathVariable("id") Integer roomId
    ){

        Room room = roomService.getRoomById(roomId);

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }


    @GetMapping("/getRoomsByBusiness/{id}")
    public ResponseEntity<List<Room>>  getRoomsByBusiness(
            @PathVariable("id") Integer businessId
    ){

        List<Room> rooms = roomService.getAllRoomsByBusiness(businessId);

        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }


    @PostMapping("/addRoomType")
    public ResponseEntity<RoomType> addRoomType(
            @RequestBody NewRoomTypeRequest newRoomTypeRequest
            ){

        RoomType roomType = roomService.addRoomType(newRoomTypeRequest);

        return new ResponseEntity<RoomType>(roomType, HttpStatus.CREATED);
    }


    @PostMapping("/updateRoomType/{id}")
    public ResponseEntity<RoomType> updateRoomType(
            @PathVariable("id") Integer typeId,
            @RequestBody UpdateRoomTypeRequest updateRoomTypeRequest
            ){

        RoomType roomType = roomService.updateRoomType(typeId ,updateRoomTypeRequest);

        return new ResponseEntity<RoomType>(roomType, HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteRoomType/{id}")
    public ResponseEntity<Void> deleteRoomType(
            @PathVariable("id") Integer typeId
    ){
        roomService.deleteRoomType(typeId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
