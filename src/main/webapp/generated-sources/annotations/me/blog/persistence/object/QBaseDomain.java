package me.blog.persistence.object;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBaseDomain is a Querydsl query type for BaseDomain
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QBaseDomain extends BeanPath<BaseDomain> {

    private static final long serialVersionUID = 370223711L;

    public static final QBaseDomain baseDomain = new QBaseDomain("baseDomain");

    public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

    public QBaseDomain(String variable) {
        super(BaseDomain.class, forVariable(variable));
    }

    public QBaseDomain(Path<? extends BaseDomain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseDomain(PathMetadata<?> metadata) {
        super(BaseDomain.class, metadata);
    }

}

