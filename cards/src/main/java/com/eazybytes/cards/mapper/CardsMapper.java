package com.eazybytes.cards.mapper;

import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Card;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Card card, CardsDto cardsDto) {
        cardsDto.setCardNumber(card.getCardNumber());
        cardsDto.setCardType(card.getCardType());
        cardsDto.setMobileNumber(card.getMobileNumber());
        cardsDto.setTotalLimit(card.getTotalLimit());
        cardsDto.setAvailableAmount(card.getAvailableAmount());
        cardsDto.setAmountUsed(card.getAmountUsed());
        return cardsDto;
    }

    public static Card mapToCards(CardsDto cardsDto, Card card) {
        card.setCardNumber(cardsDto.getCardNumber());
        card.setCardType(cardsDto.getCardType());
        card.setMobileNumber(cardsDto.getMobileNumber());
        card.setTotalLimit(cardsDto.getTotalLimit());
        card.setAvailableAmount(cardsDto.getAvailableAmount());
        card.setAmountUsed(cardsDto.getAmountUsed());
        return card;
    }

}