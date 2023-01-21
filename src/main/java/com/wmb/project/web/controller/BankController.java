package com.wmb.project.web.controller;

import com.wmb.project.domain.BankD;
import com.wmb.project.domain.service.BankService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/all")
    @ApiOperation("Get all banks")
    @ApiResponse(code=200, message = "OK")
    public ResponseEntity<List<BankD>> getAll() {
        return new ResponseEntity<>(bankService.getAllBanks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get bank by ID")
    @ApiResponses({
            @ApiResponse(code=200, message = "OK"),
            @ApiResponse(code=404, message = "Bank not found"),
    })
    public ResponseEntity<BankD> getBank(@ApiParam(value = "The id of the bank", required = true, example = "7")
                                             @PathVariable("id") Integer bankId){
        return this.bankService.getBank(bankId)
                .map(bankD -> new ResponseEntity<>(bankD, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a new bank")
    @ApiResponse(code = 200, message = "OK")
    public BankD save(@RequestBody BankD bankD){
        return bankService.save(bankD);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete bank by ID")
    @ApiResponses({
            @ApiResponse(code=200, message = "OK"),
            @ApiResponse(code=404, message = "Bank not found"),
    })
    public ResponseEntity<List<BankD>> delete(@ApiParam(value = "The id of the bank", required = true, example = "7")
                                                  @PathVariable("id") int bankId){
        if (!bankService.delete(bankId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    @ApiOperation("Update bank")
    @ApiResponses({
            @ApiResponse(code=200, message = "OK"),
            @ApiResponse(code=404, message = "Bank not found"),
    })
    public ResponseEntity<BankD> update(@RequestBody BankD bankD){
        //No viene ningún id en el update
        if (bankD == null || bankD.getBankId() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankService.update(bankD), HttpStatus.OK);

    }
}
