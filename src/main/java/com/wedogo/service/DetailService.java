package com.wedogo.service;

import com.wedogo.dto.DetailDTO;
import com.wedogo.entity.DetailEntity;
import com.wedogo.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailService {
    private final DetailRepository detailRepository;

    public void save(DetailDTO detailDTO) throws IOException {
        DetailEntity detailEntity = DetailEntity.toDetailEntity(detailDTO);
        detailRepository.save(detailEntity);
    }

    @Transactional
    public List<DetailDTO> findAll() {
        List<DetailEntity> detailEntityList = detailRepository.findAll();
        List<DetailDTO> detailDTOList = new ArrayList<>();
        for (DetailEntity detailEntity : detailEntityList) {
            detailDTOList.add(DetailDTO.toDetailDTO(detailEntity));
        }
        return detailDTOList;
    }

    public DetailDTO update(DetailDTO detailDTO) {
        DetailEntity detailEntity = DetailEntity.toUpdateDetailEntity(detailDTO);
        detailRepository.save(detailEntity);
        return findByRoomnumber(detailDTO.getRoomNumber());
    }

    public void deleteById(Long roomNumber) {
        detailRepository.deleteById(roomNumber);
    }

    public DetailDTO findByRoomnumber(Long roomNumber) {
        Optional<DetailEntity> optionalDetailEntity = detailRepository.findById(roomNumber);
        if (optionalDetailEntity.isPresent()) {
            DetailEntity detailEntity = optionalDetailEntity.get();
            DetailDTO detailDTO = DetailDTO.toDetailDTO(detailEntity);
            return detailDTO;
        } else {
            return null;
        }
    }
}
