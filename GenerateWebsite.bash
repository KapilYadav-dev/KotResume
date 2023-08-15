#!/bin/bash

read -p "Enter the new URL for RESUME_JSON_URL: " new_url

# Define paths
utils_file="composeApp/src/commonMain/kotlin/in/mrkaydev/portfolio/utils/Utils.kt"
output_folder="composeApp/build"

# Create a temporary file for modified content
temp_file=$(mktemp)

# Replace the RESUME_JSON_URL line in the Utils.kt file and write to the temporary file
awk -v new_url="$new_url" '
{
    if ($0 ~ /const val RESUME_JSON_URL = /) {
        printf("    const val RESUME_JSON_URL = \"%s\"\n", new_url);
    } else {
        print;
    }
}' "$utils_file" > "$temp_file"

# Overwrite the original file with the modified content
mv "$temp_file" "$utils_file"

# Navigate to the root directory of the project
# cd /path/to/root/directory  # Replace with the actual path to the root directory

# Run Gradle command in the background
./gradlew jsBrowserProductionWebpack &

# Wait for the Gradle task to finish
wait

# Determine the operating system and open the output folder
if [[ "$OSTYPE" == "linux-gnu" ]]; then
    xdg-open "$output_folder/dist/js"
elif [[ "$OSTYPE" == "darwin"* ]]; then
    open "$output_folder/dist/js"
elif [[ "$OSTYPE" == "msys" || "$OSTYPE" == "win32" || "$OSTYPE" == "cygwin" ]]; then
    explorer "$output_folder/dist/js"
else
    echo "Operating system not supported for automatic folder opening."
fi

echo "Wohooooo !! Generated your source code. Just now drag and drop this folder and use json to made changes on the fly..."
