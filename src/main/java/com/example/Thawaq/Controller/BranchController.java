package com.example.Thawaq.Controller;

import com.example.Thawaq.Api.ApiResponse;
import com.example.Thawaq.Model.Branch;
import com.example.Thawaq.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/branch")
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/get")
    public ResponseEntity getBranches()
    {
        return ResponseEntity.status(200).body(branchService.getBranches());
    }


    @PostMapping("/add/{storeAdminID}/{storeID}") //v2
    public ResponseEntity addBranch(@PathVariable Integer storeAdminID,@PathVariable Integer storeID, @Valid@RequestBody Branch branch)
    { //v2
        branchService.addBranch(storeAdminID,storeID, branch);
        return ResponseEntity.status(200).body(new ApiResponse("Branch added"));
    }
    @PutMapping("/update/{storeAdminID}/{storeID}/{branchID}") //v2
    public ResponseEntity updateBranch(@PathVariable Integer storeAdminID,@PathVariable Integer storeID,@PathVariable Integer branchID,@Valid@RequestBody Branch branch)
    { //v2
        branchService.updateBranch(storeAdminID,storeID,branchID,branch);
        return ResponseEntity.status(200).body(new ApiResponse("Branch updated"));
    }
    @DeleteMapping("/delete/{branchID}")
    public ResponseEntity deleteBranch(@PathVariable Integer branchID)
    {
        branchService.deleteBranch(branchID);
        return ResponseEntity.status(200).body("Branch deleted");/*new ApiResponse("Branch deleted")*/
    }

    @PutMapping("/open/{storeAdminId}/{branchId}")
    public ResponseEntity openBranch(@PathVariable Integer storeAdminId,@PathVariable Integer branchId){
        branchService.openBranch(storeAdminId, branchId);
        return ResponseEntity.status(200).body("Branch opened");
    }

    @PutMapping("/close/{storeAdminId}/{branchId}")
    public ResponseEntity closeBranch(@PathVariable Integer storeAdminId,@PathVariable Integer branchId){
        branchService.closeBranch(storeAdminId, branchId);
        return ResponseEntity.status(200).body("Branch closed");
    }
}
