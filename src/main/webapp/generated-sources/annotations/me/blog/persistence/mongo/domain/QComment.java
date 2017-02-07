package me.blog.persistence.mongo.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QComment extends BeanPath<Comment> {

    private static final long serialVersionUID = -217927628L;

    public static final QComment comment = new QComment("comment");

    public final me.blog.persistence.object.QBaseDomain _super = new me.blog.persistence.object.QBaseDomain(this);

    public final StringPath content = createString("content");

    public final StringPath id = createString("id");

    public final DateTimePath<java.util.Date> insertDate = createDateTime("insertDate", java.util.Date.class);

    public final StringPath user = createString("user");

    public QComment(String variable) {
        super(Comment.class, forVariable(variable));
    }

    public QComment(Path<? extends Comment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComment(PathMetadata<?> metadata) {
        super(Comment.class, metadata);
    }

}

