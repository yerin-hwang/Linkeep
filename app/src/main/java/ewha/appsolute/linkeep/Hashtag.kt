package ewha.appsolute.linkeep

class Hashtag {
    private val parent:String // 대분류
    private var name:String // 태그 명

    constructor(parent: String, name: String) {
        this.parent = parent
        this.name = name
    }

    fun getName(): String {
        return this.name
    }

    fun getParent(): String {
        return this.parent
    }
}
