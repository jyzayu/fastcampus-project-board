package com.fastcampus.projectboard.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHashTag is a Querydsl query type for HashTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHashTag extends EntityPathBase<HashTag> {

    private static final long serialVersionUID = 931363549L;

    public static final QHashTag hashTag = new QHashTag("hashTag");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final SetPath<Article, QArticle> articles = this.<Article, QArticle>createSet("articles", Article.class, QArticle.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath hashTagName = createString("hashTagName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public QHashTag(String variable) {
        super(HashTag.class, forVariable(variable));
    }

    public QHashTag(Path<? extends HashTag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHashTag(PathMetadata metadata) {
        super(HashTag.class, metadata);
    }

}

