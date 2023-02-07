We have communities with IDs C1,C2,... and followers with IDs F1,F2,..., where each user can follow any of the communities.

We would like to find “similar” or “related” communities by finding all communities that share followers with the input one, Cx. Implement a function to return all related communities of Cx.

Example:
Community -> follower data:
C1: [F1, F3]
C2: [F1, F2]
C3: [F2]
C4: [F3]

Follower -> community data (mirrored data):
F1: [C1, C2]
F2: [C2, C3]
F3: [C1, C4]

get_related_communities(C4) -> [C1]
get_related_communities(C2) -> [C1,C3]

Assume the data for both maps is pre populated and you can use it for the problem.