package com.wedogo.board.Service;
import com.wedogo.board.entity.Userinfo;
import com.wedogo.board.repository.UserinfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserinfoService {

    private final UserinfoRepository userinfoRepository;

    public UserinfoService(UserinfoRepository userinfoRepository) {
        this.userinfoRepository = userinfoRepository;
    }

    public List<Userinfo> findAll() {
        return userinfoRepository.findAll();
    }

    public Userinfo findById(String userId) {
        return userinfoRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
    }

    @Transactional
    public Userinfo save(Userinfo userinfo) {
        return userinfoRepository.save(userinfo);
    }

    @Transactional
    public void delete(Userinfo userinfo) {
        userinfoRepository.delete(userinfo);
    }

}