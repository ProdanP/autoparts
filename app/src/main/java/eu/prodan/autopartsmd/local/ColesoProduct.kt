package eu.prodan.autopartsmd.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by User on 12.04.2018.
 */
@Entity(tableName = "coleso")
class ColesoProduct {
    @PrimaryKey
    @NonNull lateinit var id: String

}