package com.wedogo.controller;




import com.wedogo.hotel.dto.ItemDTO;
import com.wedogo.hotel.entity.ItemEntity;
import com.wedogo.hotel.repository.ItemRepository;
import com.wedogo.hotel.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class ItemController {
    // 생성자 주입
    public final ItemService itemService;

    @Autowired
    public final ItemRepository itemRepository;

    // 상품등록 페이지 출력 요청
    @GetMapping("layout/itemForm")
    public String saveitem() {
        return "layout/itemForm";
    }


    @PostMapping("layout/itemForm")
    public String postitem(@ModelAttribute ItemDTO itemDTO) {
        System.out.println("itemDTO = " + itemDTO);
        itemService.saveitem(itemDTO);
        return "layout/Main";
    }

    @GetMapping("layout/Clist")
    public String findAllitem(Model model) {
        List<ItemDTO> itemDTOList = itemService.findAllitem();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("itemList", itemDTOList);
        return "layout/Clist";
    }

    @GetMapping("layout/{id}")
    public String findByid(@PathVariable String id, Model model) {
        ItemDTO itemDTO = itemService.findById(id);
        model.addAttribute("item", itemDTO);
        return "layout/itemDtl2";
    }

    @GetMapping("/item")
    public String item() {
        return "view/item.html";
        /*update(@ModelAttribute ItemDTO itemDTO){
        itemService.update(itemDTO);
        return "/item";
*/
    }

    @PostMapping("/item")
    public ResponseEntity<String> addItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = ItemEntity.toItemEntity(itemDTO);
        itemRepository.save(itemEntity);
        return ResponseEntity.ok("Success");
    }
}

