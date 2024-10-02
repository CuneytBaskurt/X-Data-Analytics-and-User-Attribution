Description
X Data Analytics and User Attribution is a Java-based project that processes large datasets to analyze user behavior and attribute actions to specific users. 
This system is designed to extract insights from data, including user activity tracking, region and language identification, and interest-based user matching. 
It is useful for projects that involve user profiling, segmentation, and interest-based recommendations.

Features
.User data extraction: Parses and processes large datasets to extract key user information.
.Follower-followed relationship analysis: Analyzes relationships between users to determine social connections.
.Region and language detection: Identifies the region and language based on user metadata.
.Interest-based matching: Matches users based on common interest areas, facilitating user segmentation or recommendation systems.
.Data attribution: Links actions and behaviors to individual users for deeper insights.

Technologies Used
.Java: Core language used for data processing and analytics.
.JSON Parsing: Extracts information from datasets in JSON format.
.File handling: Used to manage large datasets and output results.

Installation
1.Clone the repository:
git clone https://github.com/CuneytBaskurt/X-Data-Analytics-and-User-Attribution.git
2.Navigate to the project directory:
cd X-Data-Analytics-and-User-Attribution
3.Compile and run the project using the following commands:
javac Main.java
java Main

Usage
.Input data: Ensure that your dataset is in JSON format and follows the expected schema for user information.
.Run the analysis: The program will process the dataset, extracting user details, relationships, and other key insights.
.Output: The results, including user interests, region/language attribution, and matching information, will be saved to a file or displayed in the console.

Data Requirements
.The input dataset should be in JSON format, containing fields such as user ID, followers, region, language, and interest areas.
.The system expects structured data that can be parsed and processed in a meaningful way.
