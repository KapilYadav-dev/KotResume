#!/bin/bash

# Specify the file path
file_path="./composeApp.js"

# File to store the URL
url_file="./url.txt"

# Specify the old URL
old_url="URL_TO_REPLACE"

# If the URL file exists, read the old URL from it
if [ -f "$url_file" ]; then
    old_url=$(cat "$url_file")
fi

# Ask the user for the new URL
# shellcheck disable=SC2162
read -p "Enter the new URL: " new_url

# Save the new URL as the old URL in the file
echo "$new_url" > "$url_file"

# Escape slashes in the new URL
new_url_escaped=$(echo "$new_url" | sed 's/[\/&]/\\&/g')

# Determine the operating system
os_name=$(uname)

# Perform the replacement based on the operating system
if [ "$os_name" == "Linux" ] || [ "$os_name" == "Darwin" ]; then
    sed -i '' "s|$old_url|$new_url_escaped|g" "$file_path"
    echo "URLs replaced successfully!"
elif [ "$os_name" == "MINGW64_NT-10.0" ]; then
    # For Windows using Git Bash or similar
    sed -i "s|$old_url|$new_url_escaped|g" "$file_path"
    echo "URLs replaced successfully!"
else
    echo "Unsupported operating system: $os_name"
fi
