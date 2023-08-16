#!/bin/bash


# Install Gradle if not already installed
if ! command -v gradle &> /dev/null; then
    echo "Gradle is not installed. Installing..."

    # Check the operating system and install Gradle accordingly
    if [[ "$OSTYPE" == "linux-gnu" ]]; then
        sudo apt-get install gradle
        echo "Waiting for Gradle installation to complete..."
        while ! command -v gradle &> /dev/null; do
            sleep 2
        done
        echo "Gradle installation completed."
    elif [[ "$OSTYPE" == "darwin"* ]]; then
        brew install gradle
        echo "Waiting for Gradle installation to complete..."
        while ! command -v gradle &> /dev/null; do
            sleep 2
        done
        echo "Gradle installation completed."
    elif [[ "$OSTYPE" == "msys" || "$OSTYPE" == "win32" || "$OSTYPE" == "cygwin" ]]; then
        # Add instructions for manual installation on Windows
        echo "Gradle installation on Windows requires manual steps."
        echo "Please download and install Gradle distribution for Windows."
        exit 1
    else
        echo "Operating system not supported for automatic Gradle installation."
        exit 1
    fi
fi

# shellcheck disable=SC2162
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
