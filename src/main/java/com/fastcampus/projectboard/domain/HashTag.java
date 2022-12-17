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
public class HashTag extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToMany(mappedBy = "hashTags")
    private Set<Article> articles = new LinkedHashSet<>();

    @Setter @Column(nullable = false, length = 50) private String hashTagName;


    public HashTag() {
    }

    private HashTag(Long id, String hashTagName) {
        this.id = id;
        this.hashTagName = hashTagName;
    }

    public static HashTag of(Long id, String hashTagName) {
        return new HashTag(id, hashTagName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return id.equals(hashTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
