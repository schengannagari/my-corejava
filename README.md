<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Git Basic Commands</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
        }
        h1, h2 {
            color: #333;
        }
        code {
            background-color: #f4f4f4;
            padding: 2px 4px;
            border-radius: 4px;
            font-size: 1.1em;
        }
        pre {
            background-color: #f4f4f4;
            padding: 10px;
            border-radius: 4px;
            overflow-x: auto;
        }
    </style>
</head>
<body>

    <h1>my-corejava</h1>

    <h2>Git Basic Commands</h2>

    <pre><code>git config --global user.name "&lt;user name&gt;"</code></pre>
    <pre><code>git config --global user.email "&lt;user email&gt;"</code></pre>

    <h3>To list all the global configurations:</h3>
    <pre><code>git config --global --list</code></pre>

    <h3>To list all the configurations (both global & user level):</h3>
    <pre><code>git config --list</code></pre>

    <h3>This file contains all of the configuration information:</h3>
    <pre><code>git ~/.gitconfig</code></pre>

    <h3>The git repository will be initialized with the specified branch name by using this command:</h3>
    <pre><code>git init &lt;branch name&gt;</code></pre>

    <h3>To rename the branch:</h3>
    <pre><code>git branch -M &lt;new branch name&gt;</code></pre>

    <h3>This will link with your GitHub repository:</h3>
    <pre><code>git remote add origin &lt;github repository URL&gt;</code></pre>

    <h3>To check the status of the branch:</h3>
    <pre><code>git status</code></pre>

    <h3>To add the untracked/modified files to staging:</h3>
    <pre><code>git add &lt;file(s) names&gt;</code></pre>

    <h3>Commit the files into the local repository:</h3>
    <pre><code>git commit -m "comment"</code></pre>

    <h3>Push the local changes into the remote repository:</h3>
    <pre><code>git push origin &lt;origin branch name&gt;</code></pre>

    <h3>To get the latest code changes:</h3>
    <pre><code>git pull</code></pre>

    <h3>To unstage the staged file:</h3>
    <pre><code>git reset --hard &lt;file name&gt;</code></pre>

    <h3>To discard changes in the working directory:</h3>
    <pre><code>git checkout -- &lt;file name&gt;</code></pre>

    <h3>Remove the file:</h3>
    <pre><code>git rm &lt;file name&gt;</code></pre>

    <h3>Add all the modified files:</h3>
    <pre><code>git add -u/--update</code></pre>

    <h3>Rename/move the file:</h3>
    <pre><code>git mv &lt;file name&gt; &lt;destination filename&gt;</code></pre>

    <h3>Generating the SSH key:</h3>
    <pre><code>ssh-keygen -t rsa -C "your email address"</code></pre>

    <h3>To test the SSH connection:</h3>
    <pre><code>ssh -T git@github.com</code></pre>

    <h3>Set default branch name as part of the initialization:</h3>
    <pre><code>git init -b &lt;default branch name&gt; &lt;new branch name&gt;</code></pre>

    <h3>To set origin:</h3>
    <pre><code>git push -u origin main</code></pre>

</body>
</html>
