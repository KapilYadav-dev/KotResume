#!/bin/bash

# Specify the file path
file_path="./composeApp.js"

# Specify the old URL
old_url="URL_TO_REPLACE"

# Ask the user for the new URL
read -p "Enter the new URL: " new_url

# Escape slashes in the new URL
new_url_escaped=$(echo "$new_url" | sed 's/[\/&]/\\&/g')

# Determine the operating system
os_name=$(uname)

# Create a backup folder
backup_folder="backupComposeJsFolder"
mkdir -p "$backup_folder"

# Copy files to the backup folder
cp "$file_path" "$backup_folder"

# Perform the replacement based on the operating system
if [ "$os_name" == "Linux" ] || [ "$os_name" == "Darwin" ]; then
    sed -i '' "s|$old_url|$new_url_escaped|g" $file_path
    echo "URLs replaced successfully!"
elif [ "$os_name" == "MINGW64_NT-10.0" ]; then
    # For Windows using Git Bash or similar
    sed -i "s|$old_url|$new_url_escaped|g" $file_path
    echo "URLs replaced successfully!"
else
    echo "Unsupported operating system: $os_name"
fi
