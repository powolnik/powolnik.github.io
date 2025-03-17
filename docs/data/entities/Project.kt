// entire file content ...
package com.powolnik.portfolio.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "projects",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = ["id"],
        childColumns = ["category_id"]
    )]
)
data class Project(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val description: String?,
    val category_id: Int, // Foreign key to Category
    val tech_stack: String, // Comma-separated list of technologies
    val main_image_url: String?
)
