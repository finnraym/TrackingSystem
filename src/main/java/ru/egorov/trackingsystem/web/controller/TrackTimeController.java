package ru.egorov.trackingsystem.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egorov.trackingsystem.service.SimpleService;
import ru.egorov.trackingsystem.service.TrackingAsyncTimeService;
import ru.egorov.trackingsystem.web.dto.TrackTimeDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/track-time")
@RequiredArgsConstructor
@Tag(name = "Track time system controller", description = "Track time system APIs")
public class TrackTimeController {

    private final TrackingAsyncTimeService trackingAsyncTimeService;

    private final SimpleService simpleService;

    @Operation(
            summary = "Calling stub methods.",
            description = "Calling stub methods to save runtime."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema =
                    @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")})
    })
    @GetMapping("/simple-service/{execute}")
    public ResponseEntity<String> callSimpleService(@PathVariable String execute) {
        if (execute.equals("one")) simpleService.executeOne();
        else if (execute.equals("two")) simpleService.executeTwo();
        else if (execute.equals("three")) simpleService.executeThree();
        else return ResponseEntity.badRequest().build();
        return ResponseEntity.ok("Ok");
    }

    @Operation(
            summary = "Get statistics",
            description = "Getting statistics for all processed methods"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema =
                    @Schema(implementation = TrackTimeDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")})
    })
    @GetMapping("/statistics/all")
    public ResponseEntity<List<TrackTimeDto>> getTrackTimeStatisticAll() {
        return ResponseEntity.ok(trackingAsyncTimeService.getCommonStatistics());
    }

    @Operation(
            summary = "Get statistics by method name",
            description = "Getting statistics for processed methods by method name"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema =
                    @Schema(implementation = TrackTimeDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")})
    })
    @GetMapping("/statistics/method-name")
    public ResponseEntity<TrackTimeDto> getTrackTimeStatisticMethodName(@RequestParam String methodName) {
        return ResponseEntity.ok(trackingAsyncTimeService.getStatisticsByMethodName(methodName));
    }

    @Operation(
            summary = "Get statistics by class name",
            description = "Getting statistics for processed methods by class name"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema =
                    @Schema(implementation = TrackTimeDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")})
    })
    @GetMapping("/statistics/class-name")
    public ResponseEntity<TrackTimeDto> getTrackTimeStatisticClassName(@RequestParam String className) {
        return ResponseEntity.ok(trackingAsyncTimeService.getStatisticsByClassName(className));
    }

    @Operation(
            summary = "Get statistics by method signature",
            description = "Getting statistics for processed methods by method signature"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema =
                    @Schema(implementation = TrackTimeDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema =
                    @Schema(implementation = String.class, description = "Error message"), mediaType = "application/json")})
    })
    @GetMapping("/statistics/signature")
    public ResponseEntity<TrackTimeDto> getTrackTimeStatisticMethodSignature(@RequestParam("signature") String methodSignature) {
        return ResponseEntity.ok(trackingAsyncTimeService.getStatisticsByMethodSignature(methodSignature));
    }

}
