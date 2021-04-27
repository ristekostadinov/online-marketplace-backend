package com.example.demo.model

import javax.persistence.*

@Entity
@Table(schema = "sale_ads", name = "photos")
data class Photo(@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id: Long,
                 @Column(name = "file_name")
                 val fileName: String,
                 @Column(name = "content_type")
                 val contentType: String,
                 @Column(name = "bytes")
                 val bytes: ByteArray,
                 @Column(name = "size")
                 val size: Long )
