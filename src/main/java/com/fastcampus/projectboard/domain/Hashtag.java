package com.fastcampus.projectboard.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@ToString(callSuper = true)
@Getter
@Table(indexes = {
        @Index(columnList = "hashTagName"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Hashtag extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToMany(mappedBy = "hashtags")
    private Set<Article> articles = new LinkedHashSet<>();

    @Setter @Column(nullable = false, length = 50) private String hashtagName;


    public Hashtag() {
    }

    private Hashtag(Long id, String hashtagName) {
        this.id = id;
        this.hashtagName = hashtagName;
    }

    public static Hashtag of(Long id, String hashtagName) {
        return new Hashtag(id, hashtagName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashTag = (Hashtag) o;
        return id.equals(hashTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
