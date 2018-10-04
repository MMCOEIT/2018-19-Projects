
# coding: utf-8

# # The UNSW-NB15 data set

# In[1]:


import pandas as pd


# In[2]:


unsw = pd.read_csv('UNSW_NB15_training-set.csv')


# In[3]:


unsw.columns


# In[4]:


cols_to_norm = ['sbytes','dbytes','sttl','dttl','sloss','dloss','spkts','sinpkt','dinpkt','smean','dmean','dpkts','trans_depth','sjit','djit','ct_flw_http_mthd','ct_ftp_cmd','ct_src_dport_ltm','ct_dst_sport_ltm','ct_dst_src_ltm']


# In[5]:


unsw[cols_to_norm] = unsw[cols_to_norm].apply(lambda x: (x - x.min()) / (x.max()-x.min() ))


# In[6]:


import tensorflow as tf


# In[7]:


spkts = tf.feature_column.numeric_column('spkts')
dpkts = tf.feature_column.numeric_column('dpkts')
sbytes = tf.feature_column.numeric_column('sbytes')
dbytes = tf.feature_column.numeric_column('dbytes')
sttl = tf.feature_column.numeric_column('sttl')
dttl = tf.feature_column.numeric_column('dttl')
sloss = tf.feature_column.numeric_column('sloss')
dloss = tf.feature_column.numeric_column('dloss')
sinpkt = tf.feature_column.numeric_column('sinpkt')
dinpkt = tf.feature_column.numeric_column('dinpkt')
sjit = tf.feature_column.numeric_column('sjit')
djit = tf.feature_column.numeric_column('djit')
smean = tf.feature_column.numeric_column('smean')
dmean = tf.feature_column.numeric_column('dmean')
trans_depth = tf.feature_column.numeric_column('trans_depth')
ct_flw_http_mthd = tf.feature_column.numeric_column('ct_flw_http_mthd')
ct_ftp_cmd = tf.feature_column.numeric_column('ct_ftp_cmd')
ct_src_dport_ltm = tf.feature_column.numeric_column('ct_src_dport_ltm')
ct_dst_sport_ltm = tf.feature_column.numeric_column('ct_dst_sport_ltm')
ct_dst_src_ltm = tf.feature_column.numeric_column('ct_dst_src_ltm')


# In[8]:


assigned_grp = tf.feature_column.categorical_column_with_vocabulary_list('attack_cat', ['Fuzzers', 'Analysis', 'Backdoors', 'DoS', 'Exploits', 'Generic', 'Reconnaissance', 'Shellcode', 'Worms'])


# In[9]:


import matplotlib.pyplot as plt
get_ipython().run_line_magic('matplotlib', 'inline')


# In[10]:


feat_cols = [spkts,dpkts, sbytes, dbytes, sttl, dttl, sloss, dloss, sinpkt,dinpkt, smean, dmean, sjit, djit, trans_depth, ct_ftp_cmd, ct_src_dport_ltm, ct_dst_sport_ltm, ct_dst_src_ltm, ct_flw_http_mthd]


# In[11]:


x_data = unsw.drop('label', axis = 1)


# In[12]:


labels = unsw['label']


# In[13]:


from sklearn.model_selection import train_test_split


# In[14]:


X_train, x_test, y_train, y_test = train_test_split(x_data, labels, test_size = 0.3, random_state = 101)


# In[15]:


input_func = tf.estimator.inputs.pandas_input_fn(x = X_train, y = y_train, batch_size=10, num_epochs=1000, shuffle=True)


# In[16]:


model = tf.estimator.LinearClassifier(feature_columns=feat_cols,n_classes=9,)


# In[17]:


model.train(input_fn=input_func, steps=1000)


# In[18]:


unsw.columns


# In[19]:


x_data.columns


# In[20]:


x_data = x_data.drop('state', axis = 1)


# In[21]:


x_data.head()


# In[22]:


x_data.columns


# In[23]:


cols_to_norm = ['dur', 'spkts', 'dpkts', 'sbytes', 'dbytes', 'rate',
       'sttl', 'dttl', 'sload', 'dload', 'sloss', 'dloss', 'sinpkt', 'dinpkt',
       'sjit', 'djit', 'swin', 'stcpb', 'dtcpb', 'dwin', 'synack', 'ackdat',
       'smean', 'dmean']


# In[24]:


x_data[cols_to_norm] = x_data[cols_to_norm].apply(lambda x: (x - x.min())/(x.max()-x.min()))


# In[25]:


eval_input_function = tf.estimator.inputs.pandas_input_fn(x = x_test, y = y_test, batch_size=10, num_epochs=1,shuffle=False)


# In[26]:


results = model.evaluate(eval_input_function)


# In[27]:


results


# In[28]:


pred_input_func = tf.estimator.inputs.pandas_input_fn(x = x_test, batch_size=10, num_epochs=1, shuffle=False)


# In[29]:


predictions = model.predict(pred_input_func)


# In[30]:


my_pred = list(predictions)


# In[31]:


my_pred


# ## DNN classifier

# In[32]:


embedded_group_col = tf.feature_column.embedding_column(assigned_grp, dimension=2)


# In[33]:


feat_cols = [spkts,dpkts, sbytes, dbytes, sttl, dttl, sloss, dloss, sinpkt,dinpkt, smean, dmean, sjit, djit, trans_depth, ct_ftp_cmd, ct_src_dport_ltm, ct_dst_sport_ltm, ct_dst_src_ltm, ct_flw_http_mthd, embedded_group_col]


# In[34]:


input_func = tf.estimator.inputs.pandas_input_fn(X_train, y_train, batch_size=10, num_epochs=1000, shuffle=True)


# In[35]:


dnn_model = tf.estimator.DNNClassifier(hidden_units=[3,5,3], feature_columns=feat_cols, n_classes=2)


# In[36]:


dnn_model.train(input_fn=input_func, steps = 1000)


# In[37]:


eval_input_func = tf.estimator.inputs.pandas_input_fn(x = x_test, y = y_test, num_epochs=1, batch_size=10, shuffle=False)


# In[38]:


dnn_model.evaluate(eval_input_func)

