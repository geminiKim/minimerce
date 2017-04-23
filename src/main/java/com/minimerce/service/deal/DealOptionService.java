package com.minimerce.service.deal;

import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 23/04/2017.
 */
@Service
public class DealOptionService {
    private final DealOptionRepository optionRepository;

    @Inject
    public DealOptionService(DealOptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public void newDeal(Long clientId, DealOption option) {
        if(option.getId() != null) return;
        option.setClientId(clientId);
        optionRepository.save(option);
    }

    public void updateDeal(Long clientId, DealOption option) {
        if(option.getId() == null) return;
        option.setClientId(clientId);
        optionRepository.save(option);
    }
}
