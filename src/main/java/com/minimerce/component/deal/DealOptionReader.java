package com.minimerce.component.deal;

import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 10/04/2017.
 */
@Component
public class DealOptionReader extends EntityReader {
    private final DealOptionRepository repository;

    @Inject
    public DealOptionReader(DealOptionRepository repository) {
        this.repository = repository;
    }

    public DealOption findById(Long id) {
        DealOption one = repository.findOne(id);
        validate(one);
        return one;
    }

    public List<DealOption> findAll() {
        List<DealOption> list = repository.findAll();
        validate(list);
        return list;
    }

    public DealOption findByClientOption(Long clientId, Long optionId) {
        DealOption one = repository.findByClientIdAndId(clientId, optionId);
        validate(one);
        return null;
    }
}
