package com.dhotels.hotelsbackend.services;

import com.dhotels.hotelsbackend.exception.ResourceNotFoubdException;
import com.dhotels.hotelsbackend.helpers.NewRoomRequest;
import com.dhotels.hotelsbackend.helpers.NewRoomTypeRequest;
import com.dhotels.hotelsbackend.helpers.UpdateRoomReq;
import com.dhotels.hotelsbackend.helpers.UpdateRoomTypeRequest;
import com.dhotels.hotelsbackend.modules.Booking;
import com.dhotels.hotelsbackend.modules.Business;
import com.dhotels.hotelsbackend.modules.Package;
import com.dhotels.hotelsbackend.modules.Room;
import com.dhotels.hotelsbackend.modules.RoomType;
import com.dhotels.hotelsbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRespository roomRespository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    BookingRepository bookingRepository;


    ///todo {rooms crude}
    ///adding room to a Business ----/
    ///getting all business rooms  ----/
    ///get room by id  ----/
    ///update room  ----/
    ///delete room  ----/
    ///adding room Type ----/
    ///update room Type ----/
    ///delete room Type ----/



    public Room  addRoom(
            NewRoomRequest newRoomRequest
            ){

        Business business = businessRepository.findById(
                newRoomRequest.getBusiness()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business not Found"
                )
        );

        RoomType roomType = roomTypeRepository.findById(
                newRoomRequest.getRoomType()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "RoomType not found"
                )
        );

        Room room = new Room(
                newRoomRequest.getRoomNumber(),
                newRoomRequest.getCapacity(),
                newRoomRequest.getBed(),
                new ArrayList<String>(),
                newRoomRequest.getDescription(),
                roomType,
                business,
                newRoomRequest.getPrice(),
                new ArrayList<Booking>(),
                new ArrayList<String>(),
                new ArrayList<Package>()
        );

        Room savedRoom =  roomRespository.save(room);

        roomType.getRooms().add(savedRoom);
        business.getRoomList().add(savedRoom);

        roomTypeRepository.save(roomType);
        businessRepository.save(business);

        return savedRoom;
    }


    public Room getRoomById(
            Integer roomId
    ){
        return roomRespository.findById(roomId)
                .orElseThrow(
                        ()-> new ResourceNotFoubdException(
                                "Room Not Found"
                        )
                );
    }


    public Room updateRoom(
            Integer roomId,
            UpdateRoomReq updateRoomReq
    ){

        Room room = roomRespository.findById(
                roomId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Room not found"
                )
        );

        RoomType prevRoomType = room.getRoomType();

        RoomType roomType = roomTypeRepository.findById(
                updateRoomReq.getRoomType()
        ).orElseThrow(
                () -> new ResourceNotFoubdException(
                        "RoomType not found"
                )
        );

        prevRoomType.getRooms().remove(room);

        room.setRoomNumber(updateRoomReq.getRoomNumber());
        room.setRoomType(roomType);
        room.setBeds(updateRoomReq.getBeds());
        room.setDescription(updateRoomReq.getDescription());
        room.setCapacity(updateRoomReq.getCapacity());
        room.setPrice(updateRoomReq.getPrice());

        Room savedRoom = roomRespository.save(room);

        roomType.getRooms().add(savedRoom);
        roomTypeRepository.save(prevRoomType);
        roomTypeRepository.save(roomType);

        return savedRoom;
    }


    public void deleteRoom(Integer roomId){
        Room room = roomRespository.findById(
                roomId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Room not found"
                )
        );

        Business business = room.getBusiness();
        RoomType roomType = room.getRoomType();

        business.getRoomList().remove(room);
        roomType.getRooms().remove(room);

        businessRepository.save(business);
        roomTypeRepository.save(roomType);

        roomRespository.delete(room);
    }

    public List<Room> getAllRoomsByBusiness(Integer businessId){

        Business business = businessRepository.findById(
                businessId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Business not found"
                )
        );


        return roomRespository.findAllByBusiness(business).orElseThrow();
    }

    public RoomType addRoomType(NewRoomTypeRequest roomTypeReq){

        RoomType roomType = new RoomType(
                roomTypeReq.getName(),
                roomTypeReq.getDescription(),
                new ArrayList<Room>()
        );

        return roomTypeRepository.save(roomType);
    }


    public RoomType updateRoomType(
            Integer roomTypeId,
            UpdateRoomTypeRequest updateRoomTypeRequest){

        RoomType roomType  = roomTypeRepository.findById(
                roomTypeId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Room type not found"
                )
        );

        roomType.setName(updateRoomTypeRequest.getName());
        roomType.setDescription(updateRoomTypeRequest.getDescription());

        return  roomTypeRepository.save(roomType);
    }


    public void deleteRoomType(Integer roomTypeId){

        RoomType roomType = roomTypeRepository.findById(
                roomTypeId
        ).orElseThrow(
                () -> new ResourceNotFoubdException(
                        "Room type not found"
                )
        );

        roomTypeRepository.delete(roomType);
    }

}
