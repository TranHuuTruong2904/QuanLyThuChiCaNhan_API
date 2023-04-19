package com.tranhuutruong.QuanLyThuChiAPI.Model.Transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tranhuutruong.QuanLyThuChiAPI.Model.Card.CardModel;
import com.tranhuutruong.QuanLyThuChiAPI.Model.Category.CategoryModel;
import com.tranhuutruong.QuanLyThuChiAPI.Model.User.UserInfoModel;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Builder
@Data
@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserInfoModel userInfoModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "card_id")
    private CardModel cardModel;


    @Column(name = "name")
    private String name;


    @Column(name = "amount")
    private Long amount;

    @Column(name = "location")
    private String location;


    @Column(name = "transactiondate")
    private Date transactiondate;

    // the loai 1 = thu vào, 2 = chi tiêu
    @Column(name = "type")
    private Long type;

    @Column(name = "description")
    private String description;
}
