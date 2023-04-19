package com.tranhuutruong.QuanLyThuChiAPI.Repository.Card;

import com.tranhuutruong.QuanLyThuChiAPI.Model.Card.CardModel;
import com.tranhuutruong.QuanLyThuChiAPI.Model.Transaction.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    @Query("SELECT c FROM CardModel c JOIN c.userInfoModel u JOIN u.accountModel a WHERE a.username = :username")
    Iterable<CardModel> findAllByUserInfoModel_AccountModel_Username(@Param("username") String username);

    @Query("SELECT c FROM CardModel c JOIN c.userInfoModel u JOIN u.accountModel a WHERE a.username = :username AND c.id = :id")
    CardModel findCardModelByUserInfoModel_AccountModel_UsernameAndId(@Param("username") String username, @Param("id") Long id);

    @Query("SELECT COUNT(t) FROM TransactionModel t WHERE t.cardModel.id = :idCard")
    Long countTransactionsByCardId(@Param("idCard") Long idCard);

    @Query("SELECT t FROM TransactionModel t WHERE t.cardModel.userInfoModel.accountModel.username = :username AND t.cardModel.id = :cardId")
    List<TransactionModel> findAllTractionModelByUserInfoModel_AccountModel_UsernameAndId(@Param("username") String username, @Param("cardId") Long cardId);
}
