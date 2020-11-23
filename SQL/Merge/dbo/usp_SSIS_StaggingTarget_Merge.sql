CREATE PROCEDURE [dbo].[usp_SSIS_StaggingTarget_Merge]
AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @ErrorMessage		[VARCHAR](2048),
			@ErrorSeverity      [INT],
			@ErrorState         [TINYINT],
			@ErrorLine          [INT],
			@ErrorNumber		[INT];

    BEGIN TRY           

		MERGE dbo.TargetTable AS dst
			USING dbo.StaggingTable AS src 
			ON (dst.ColumnPK = src.ColumnPK)
		
		-- UPDATE
		WHEN MATCHED
			THEN UPDATE SET 
				[Column1] = src.[Column1]	
			,   [Column2] = src.[Column2]
			,   [Column3] = src.[Column3]
		
		-- INSERT
		WHEN NOT MATCHED BY TARGET
			THEN INSERT (     [Column1],     [Column2],     [Column3] )
				 VALUES ( src.[Column1], src.[Column2], src.[Column3] )

		-- DELETE
		WHEN NOT MATCHED BY SOURCE
			THEN DELETE;

	END TRY      
	BEGIN CATCH
		SET    @ErrorSeverity = ERROR_SEVERITY();
		SET    @ErrorState = ERROR_STATE();
		SET    @ErrorLine = ERROR_LINE();
		SET    @ErrorNumber = ERROR_NUMBER();
		SET    @ErrorMessage = 'Error ' + CONVERT(VARCHAR(20), @ErrorNumber) + ' on line ' + CONVERT(VARCHAR(20), @ErrorLine) + ' in ' + OBJECT_NAME(@@PROCID) + ': ' + ERROR_MESSAGE();
		RAISERROR     (@ErrorMessage, @ErrorSeverity, @ErrorState)
		RETURN -1; --exit out of procedure
	END CATCH;
END