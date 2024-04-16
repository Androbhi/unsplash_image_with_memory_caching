package com.assignment.prashntadvait.data.dto
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Keep
data class ImageListDto(
    @SerializedName("alt_description")
    @Expose
    val altDescription: String?,
    @SerializedName("alternative_slugs")
    @Expose
    val alternativeSlugs: AlternativeSlugs?,
    @SerializedName("asset_type")
    @Expose
    val assetType: String?,
    @SerializedName("blur_hash")
    @Expose
    val blurHash: String?,
    @SerializedName("breadcrumbs")
    @Expose
    val breadcrumbs: List<Breadcrumb?>?,
    @SerializedName("color")
    @Expose
    val color: String?,
    @SerializedName("created_at")
    @Expose
    val createdAt: String?,
    @SerializedName("current_user_collections")
    @Expose
    val currentUserCollections: List<Any?>?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("height")
    @Expose
    val height: Int?,
    @SerializedName("id")
    @Expose
    val id: String?,
    @SerializedName("liked_by_user")
    @Expose
    val likedByUser: Boolean?,
    @SerializedName("likes")
    @Expose
    val likes: Int?,
    @SerializedName("links")
    @Expose
    val links: Links?,
    @SerializedName("promoted_at")
    @Expose
    val promotedAt: String?,
    @SerializedName("slug")
    @Expose
    val slug: String?,
    @SerializedName("sponsorship")
    @Expose
    val sponsorship: Any?,
    @SerializedName("topic_submissions")
    @Expose
    val topicSubmissions: TopicSubmissions?,
    @SerializedName("updated_at")
    @Expose
    val updatedAt: String?,
    @SerializedName("urls")
    @Expose
    val urls: Urls?,
    @SerializedName("user")
    @Expose
    val user: User?,
    @SerializedName("width")
    @Expose
    val width: Int?
) {
    @Keep
    data class AlternativeSlugs(
        @SerializedName("de")
        @Expose
        val de: String?,
        @SerializedName("en")
        @Expose
        val en: String?,
        @SerializedName("es")
        @Expose
        val es: String?,
        @SerializedName("fr")
        @Expose
        val fr: String?,
        @SerializedName("it")
        @Expose
        val `it`: String?,
        @SerializedName("ja")
        @Expose
        val ja: String?,
        @SerializedName("ko")
        @Expose
        val ko: String?,
        @SerializedName("pt")
        @Expose
        val pt: String?
    )

    @Keep
    data class Breadcrumb(
        @SerializedName("index")
        @Expose
        val index: Int?,
        @SerializedName("slug")
        @Expose
        val slug: String?,
        @SerializedName("title")
        @Expose
        val title: String?,
        @SerializedName("type")
        @Expose
        val type: String?
    )

    @Keep
    data class Links(
        @SerializedName("download")
        @Expose
        val download: String?,
        @SerializedName("download_location")
        @Expose
        val downloadLocation: String?,
        @SerializedName("html")
        @Expose
        val html: String?,
        @SerializedName("self")
        @Expose
        val self: String?
    )

    @Keep
    data class TopicSubmissions(
        @SerializedName("people")
        @Expose
        val people: People?
    ) {
        @Keep
        data class People(
            @SerializedName("approved_on")
            @Expose
            val approvedOn: String?,
            @SerializedName("status")
            @Expose
            val status: String?
        )
    }

    @Keep
    data class Urls(
        @SerializedName("full")
        @Expose
        val full: String?,
        @SerializedName("raw")
        @Expose
        val raw: String?,
        @SerializedName("regular")
        @Expose
        val regular: String?,
        @SerializedName("small")
        @Expose
        val small: String?,
        @SerializedName("small_s3")
        @Expose
        val smallS3: String?,
        @SerializedName("thumb")
        @Expose
        val thumb: String?
    )

    @Keep
    data class User(
        @SerializedName("accepted_tos")
        @Expose
        val acceptedTos: Boolean?,
        @SerializedName("bio")
        @Expose
        val bio: String?,
        @SerializedName("first_name")
        @Expose
        val firstName: String?,
        @SerializedName("for_hire")
        @Expose
        val forHire: Boolean?,
        @SerializedName("id")
        @Expose
        val id: String?,
        @SerializedName("instagram_username")
        @Expose
        val instagramUsername: Any?,
        @SerializedName("last_name")
        @Expose
        val lastName: String?,
        @SerializedName("links")
        @Expose
        val links: Links?,
        @SerializedName("location")
        @Expose
        val location: String?,
        @SerializedName("name")
        @Expose
        val name: String?,
        @SerializedName("portfolio_url")
        @Expose
        val portfolioUrl: String?,
        @SerializedName("profile_image")
        @Expose
        val profileImage: ProfileImage?,
        @SerializedName("social")
        @Expose
        val social: Social?,
        @SerializedName("total_collections")
        @Expose
        val totalCollections: Int?,
        @SerializedName("total_illustrations")
        @Expose
        val totalIllustrations: Int?,
        @SerializedName("total_likes")
        @Expose
        val totalLikes: Int?,
        @SerializedName("total_photos")
        @Expose
        val totalPhotos: Int?,
        @SerializedName("total_promoted_illustrations")
        @Expose
        val totalPromotedIllustrations: Int?,
        @SerializedName("total_promoted_photos")
        @Expose
        val totalPromotedPhotos: Int?,
        @SerializedName("twitter_username")
        @Expose
        val twitterUsername: Any?,
        @SerializedName("updated_at")
        @Expose
        val updatedAt: String?,
        @SerializedName("username")
        @Expose
        val username: String?
    ) {
        @Keep
        data class Links(
            @SerializedName("followers")
            @Expose
            val followers: String?,
            @SerializedName("following")
            @Expose
            val following: String?,
            @SerializedName("html")
            @Expose
            val html: String?,
            @SerializedName("likes")
            @Expose
            val likes: String?,
            @SerializedName("photos")
            @Expose
            val photos: String?,
            @SerializedName("portfolio")
            @Expose
            val portfolio: String?,
            @SerializedName("self")
            @Expose
            val self: String?
        )

        @Keep
        data class ProfileImage(
            @SerializedName("large")
            @Expose
            val large: String?,
            @SerializedName("medium")
            @Expose
            val medium: String?,
            @SerializedName("small")
            @Expose
            val small: String?
        )

        @Keep
        data class Social(
            @SerializedName("instagram_username")
            @Expose
            val instagramUsername: Any?,
            @SerializedName("paypal_email")
            @Expose
            val paypalEmail: Any?,
            @SerializedName("portfolio_url")
            @Expose
            val portfolioUrl: String?,
            @SerializedName("twitter_username")
            @Expose
            val twitterUsername: Any?
        )
    }
}