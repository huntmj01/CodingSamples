# SCV Mutation Testing
# Run: > ./scvStryker.ps1
# Setup: https://stryker-mutator.io/stryker-net/quickstart
#   Note: In order to run dotnet new tool-manifest you may to install dotnet core 3.0+ which is currently in preview

$solutionFolder = (Get-Item -Path "..\").FullName
$projectFile = "$solutionFolder\CopStryker\CopStryker.Api.csproj"

dotnet stryker --project-file=$projectFile