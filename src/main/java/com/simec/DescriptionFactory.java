package com.simec;

import com.simec.model.Event;

class DescriptionFactory {

    private DescriptionFactory(){}

    static String forEvent(Event event) {
        String repoName = event.getRepository().getName();
        return switch (event.getType()) {
            case "PushEvent" -> "Pushed " + event.getPayload().getCommits().length + " commit(s) to " + repoName;
            case "WatchEvent" -> "Starred " + repoName;
            case "ForkEvent" -> "Forked " + repoName;
            case "CreateEvent" -> "Created " + event.getPayload().getRefType() + " in " + repoName;
            case "DeleteEvent" -> "Deleted " + event.getPayload().getRefType() + " in " + repoName;
            case "PublicEvent" -> "Made public " + repoName;
            case "IssuesEvent" -> createActionName(event) + " new issue in " + repoName;
            case "PullRequestEvent" -> createActionName(event) + " pull request in " + repoName;
            case "IssueCommentEvent" -> createActionName(event) + " issue comment in " + repoName;
            default -> "Event " + event.getType() + " in " + repoName;
        };
    }

    private static String createActionName(Event event) {
        return event.getPayload().getAction().substring(0, 1).toUpperCase() + event.getPayload().getAction().substring(1);
    }
}
