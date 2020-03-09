package ewha.appsolute.linkeep

import android.media.Image
import android.net.Uri
import java.util.*

class Link {
    val uri:Uri
    var thumbnail:Image
    var hashtags:List<Hashtag>
    var created:Date

    constructor(uri: Uri, thumbnail: Image, hashtags: List<Hashtag>, created: Date) {
        this.uri = uri
        this.thumbnail = thumbnail
        this.hashtags = hashtags
        this.created = created
    }
}
