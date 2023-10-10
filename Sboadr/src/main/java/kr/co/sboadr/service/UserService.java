package kr.co.sboadr.service;


import kr.co.sboadr.entity.TermsEntity;
import kr.co.sboadr.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TermsRepository termsRepository;

    public TermsEntity findByTerms(){
        return termsRepository.findById(1).get();
    }


}
