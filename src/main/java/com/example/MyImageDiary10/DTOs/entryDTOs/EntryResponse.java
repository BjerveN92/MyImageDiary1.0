package com.example.MyImageDiary10.DTOs.entryDTOs;

// import java.time.ZonedDateTime;

// import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true) // Alla fält från superklassen skall ärvas till denna
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EntryResponse extends EntryResponseListItem {

    private String content;

}
