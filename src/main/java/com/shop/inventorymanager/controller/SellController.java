package com.shop.inventorymanager.controller;

import com.shop.inventorymanager.entity.Sell;
import com.shop.inventorymanager.model.SellAddRequest;
import com.shop.inventorymanager.model.SellAddResponse;
import com.shop.inventorymanager.model.SellDTO;
import com.shop.inventorymanager.service.SellService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.shop.inventorymanager.constant.Messages.SELL_ADD_ERROR;
import static com.shop.inventorymanager.constant.Messages.SELL_ADD_SUCCESS;

@RestController
@RequestMapping("/sell")
@Log4j2
public class SellController {

    @Autowired
    private SellService sellService;

    @GetMapping
    public List<SellDTO> get(@RequestParam(required = false) Optional<LocalDateTime> from,
                             @RequestParam(required = false) Optional<LocalDateTime> to) {
        log.info("Sell -> get");
        return sellService.get(from.orElse(LocalDate.now().atStartOfDay()),
                to.orElse(LocalDate.now().atTime(23,59,59)));
    }

    @PostMapping
    public SellAddResponse add(@RequestBody SellAddRequest sellAdd) {
        log.info("SellController -> add");
        Sell added = sellService.add(sellAdd);
        if(added != null) {
        return SellAddResponse.builder().message(SELL_ADD_SUCCESS).productName(added.getProduct().getName()).build();
        }
        return SellAddResponse.builder().message(SELL_ADD_ERROR).build();
    }


    @PutMapping
    public void update() {
        sellService.update();
    }

    @DeleteMapping
    public void delete() {
        sellService.delete();
    }

}
