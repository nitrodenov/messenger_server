package messenger.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "message")
data class Message(
        @Id
        @Column(name = "id")
        var id: String? = null,

        @Column(name = "text")
        var text: String? = null,

        @Column(name = "time")
        var time: String? = null,

        @Column(name = "logo")
        var logo: String? = null,

        @Column(name = "imageinmessage")
        var imageInMessage: String? = null,

        @Column(name = "isincomemessage")
        var isIncomeMessage: Boolean = false
)

