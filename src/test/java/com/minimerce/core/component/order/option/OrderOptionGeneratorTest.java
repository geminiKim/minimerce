package com.minimerce.core.component.order.option;

import com.minimerce.builder.UsableOptionBuilder;
import com.minimerce.core.component.order.option.usable.UsableOrderOptionGenerator;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.object.deal.type.ProductType;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 14/06/2017.
 */
public class OrderOptionGeneratorTest {
    private OrderOptionGenerator generator;
    private final UsableOrderOptionGenerator mockUsableOrderOptionGenerator = mock(UsableOrderOptionGenerator.class);
    private final UsableOptionBuilder optionBuilder = UsableOptionBuilder.anUsableOption();

    @Before
    public void setup() {
        generator = new OrderOptionGenerator(mockUsableOrderOptionGenerator);
    }

    @Test
    public void testShouldBeGenerateUsableOptionOrder() {
        Long clientId = 1L;
        Option usableOption = optionBuilder.withType(ProductType.USABLE).build();
        generator.generate(clientId, usableOption);

        verify(mockUsableOrderOptionGenerator).generate(clientId, (UsableOption) usableOption);
    }
}