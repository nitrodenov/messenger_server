package messenger.model

import org.hibernate.annotations.Type
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "shortchanneldata")
data class ShortChannelData(
        @Id
        @Column(name = "id")
        var id: String? = null,

        @Column(name = "title")
        var title: String? = null,

        @Column(name = "description")
        var description: String? = null,

        @Column(name = "time")
        var time: String? = null,

        @Column(name = "logos", columnDefinition = "text[]")
        @Type(type = "messenger.model.StringArrayType")
        var logos: Array<String>? = null
)