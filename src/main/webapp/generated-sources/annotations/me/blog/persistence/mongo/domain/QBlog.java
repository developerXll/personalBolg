package me.blog.persistence.mongo.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBlog is a Querydsl query type for Blog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBlog extends EntityPathBase<Blog> {

    private static final long serialVersionUID = 1040434669L;

    public static final QBlog blog = new QBlog("blog");

    public final me.blog.persistence.object.QBaseDomain _super = new me.blog.persistence.object.QBaseDomain(this);

    public final StringPath brief = createString("brief");

    public final StringPath category = createString("category");

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

    public final DateTimePath<java.util.Date> insertDate = createDateTime("insertDate", java.util.Date.class);

    public final ListPath<String, StringPath> labels = this.<String, StringPath>createList("labels", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public QBlog(String variable) {
        super(Blog.class, forVariable(variable));
    }

    public QBlog(Path<? extends Blog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlog(PathMetadata<?> metadata) {
        super(Blog.class, metadata);
    }

}

