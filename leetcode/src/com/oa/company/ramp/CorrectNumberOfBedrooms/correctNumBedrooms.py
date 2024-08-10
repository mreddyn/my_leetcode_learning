import json


def correct_num_bedrooms(json_data):
    # Parse the JSON data
    listings = json.loads(json_data)
    num_bedrooms_list = []

    for listing in listings:
        description = listing.get("description", "").lower()
        num_bedrooms = listing.get("num_bedrooms", -1)

        # Check if 'studio' or '1-bedroom' is in the description
        is_studio = " studio" in description
        is_one_bedroom = " 1-bedroom" in description

        # Edge cases: "yoga", "dance", or "art" before "studio" or "1-bedroom"
        has_exclusion = (
            "yoga studio" in description
            or "dance studio" in description
            or "art studio" in description
            or "yoga 1-bedroom" in description
            or "dance 1-bedroom" in description
            or "art 1-bedroom" in description
        )

        if not has_exclusion:
            if is_studio and not is_one_bedroom:
                num_bedrooms = 0
            elif is_one_bedroom and not is_studio:
                num_bedrooms = 1

        num_bedrooms_list.append(num_bedrooms)

    return num_bedrooms_list


# Example usage
json_data = """
[
    {"description": "Beautiful 1-bedroom apartment with nearby yoga studio.", "num_bedrooms": 0},
    {"description": "Spacious studio in downtown.", "num_bedrooms": 1},
    {"description": "1-bedroom apartment with great views.", "num_bedrooms": 0}
]
"""

corrected_num_bedrooms = correct_num_bedrooms(json_data)
print(corrected_num_bedrooms)
