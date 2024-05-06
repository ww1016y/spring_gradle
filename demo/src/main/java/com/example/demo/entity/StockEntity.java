package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Data
@Entity
@Table(name="melondb")
public class StockEntity {

    @Id
    @Column(name="rrank")
    private Integer rrank;

    @Column(name ="NAME")
    private String name;

    @Column(name="artist")
    private String artist;

    @Column(name="album")
    private String album;

    public void updateArtist(String artist){
        artist = artist + "QQ";
        this.artist = artist;
    }

}
