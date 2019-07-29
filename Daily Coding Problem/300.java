// from heapq import heappush, heapify


// class VoterFraudException(Exception):
//     pass


// class Candidate:
//     def __init__(self, name: int):
//         self.name = name
//         self.vote_count = 0

//     def __eq__(self, other):
//         return self.vote_count == other.vote_count

//     def __lt__(self, other):
//         return self.vote_count < other.vote_count

//     def __gt__(self, other):
//         return self.vote_count > other.vote_count

//     def __repr__(self):
//         return "Candidate: {}, Votes: {}".format(self.name, self.vote_count)


// class VotingMachine:
//     def __init__(self):
//         self.votes = dict()
//         self.leaderboard = list()
//         self.voters = set()

//     def cast_vote(self, candidate: int, voter: int):
//         if voter in self.voters:
//             raise VoterFraudException(
//                 "Fraud committed by voter {}".format(voter))
//         self.voters.add(voter)

//         if not candidate in self.votes:
//             cand_obj = Candidate(candidate)
//             heappush(self.leaderboard, cand_obj)
//             self.votes[candidate] = cand_obj
//         cand_obj = self.votes[candidate]
//         cand_obj.vote_count += 1

//     def get_top_three(self):
//         heapify(self.leaderboard)
//         return [x.name for x in self.leaderboard[-3:]]


// def process_votes(vm, file_contents):
//     for (candidate, voter) in file_contents:
//         vm.cast_vote(candidate, voter)